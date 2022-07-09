<template>
  <div v-if="this.isOpen" class="dialog-import" @click="this.isOpen = false">
    <form class="form-import">
      <input class="input-file" type="file" accept=".xml" @change="uploadFile"/>
      <input class="input-text" type="text" v-model="this.nameFile" placeholder="название файла" maxlength="20">
      <button class="btn-import" @click="fetchSaveFile">Сохранить</button>
    </form>
  </div>
</template>

<script>
export default {

  data() {
    return {
      url: '/api/file',
      idFile: 0,
      nameFile: '',
      isOpen: false
    }
  },

  methods: {

    uploadFile(e) {
      this.file = e.target.files[0];
    },

    async fetchSaveFile() {

      this.idFile = Date.now();
      let content = await this.file.text();

      let xml = `<FileInfo IdFile=${this.idFile} NameFile=${this.nameFile}>
                       ${content}
                  </FileInfo>`

      let data = new FormData();
      data.append('file', xml);

      try {
        let response = await fetch(this.url, {
          headers: {
            "Content-Type": "text/xml"
          },
          body: data,
          method: "post"
        });

        console.log(response);
      } catch(error) {
        console.log(error)
      }

      this.isOpen = false;
    }
  }
}
</script>

<style scoped>
.dialog-import {
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0,0,0,0.5);
}

.form-import {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 320px;
  height: 160px;
  background: #fff;
  border-radius: 20px;
}

.input-file {
  font-size: 14px;
  margin-bottom: 20px;
  cursor: pointer;
}

.input-text {
  font-size: 16px;
  margin-bottom: 20px;
  padding-left: 10px;
  width: 280px;
  border-radius: 5px;
  outline: none;
  border: none;
  box-shadow: 0 0 10px #000;
}

.btn-import {
  font-size: 16px;
  width: 200px;
  height: 25px;
  border-radius: 5px;
  border: none;
  background: #badb3c;
  cursor: pointer;
}

.btn-import:hover {
  box-shadow: 0 0 10px #badb3c;
}


</style>