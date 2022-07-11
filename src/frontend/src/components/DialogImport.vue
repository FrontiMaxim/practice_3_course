<template>
  <div v-if="this.isOpen" class="dialog-import">
    <form class="form-import">
      <input class="input-file" type="file" accept=".xml" @change="uploadFile"/>
      <input class="input-text" type="text" v-model="this.nameFile" placeholder="название файла" maxlength="20">
      <button class="btn-import" @click="fetchSaveFile">Сохранить</button>
      <button class="btn-cancel" @click="$emit('cancelSave')">Отменить</button>
    </form>
  </div>
</template>

<script>
export default {

  props: {
    isOpen: {
      type: Boolean,
      required: true
    }
  },

  data() {
    return {
      url: '/api/file',
      idFile: 0,
      nameFile: ''
    }
  },

  methods: {

    uploadFile(e) {
      this.file = e.target.files[0];
    },

    async fetchSaveFile() {

      this.$emit('sendingFile')
      this.idFile = Date.now();
      let content = await this.file.text();

      let xml = `<FileInfo IdFile=${this.idFile} nameFile=${this.nameFile}>
                       ${content}
                  </FileInfo>`

      let data = new FormData();
      //data.append('file', xml);
      data.append('file', this.file);
      data.append('nameFile', this.nameFile);

      try {
        let response = await fetch(this.url, {
          body: data,
          method: "post"
        });

        this.$emit('updateListFiles');
      } catch(error) {
        console.log(error)
      }
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
  background: #c4cdd3;
  cursor: pointer;
  margin-bottom: 10px;
  box-shadow: 0 0 3px #000;
}

.btn-import:hover {
  box-shadow: 0 0 10px #000;
}

.btn-cancel {
  font-size: 16px;
  width: 200px;
  height: 25px;
  border-radius: 5px;
  cursor: pointer;
  border: none;
  background: none;
  box-shadow: 0 0 3px #000;
}

.btn-cancel:hover {
  box-shadow: 0 0 10px #000;
}


</style>