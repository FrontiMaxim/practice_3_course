<template>
  <div>
    <input type="file" accept=".xml" @change="uploadFile"/>
    <button @click="fetchFile">Сохранить</button>
  </div>
</template>

<script>
export default {

  data() {
    return {
      file: null,
      url: '/api/file'
    }
  },

  methods: {

    uploadFile(e) {
      this.file = e.target.files[0];
    },

    fetchFile() {

      let data = new FormData();
      data.append('file', this.file);


      fetch(this.url, {
        headers: {
          "Content-Type": "application/json;charset=UTF-8"
        },
        body: data,
        method: "post"
      })
      .then(response => response.json).then(data => console.log(data))
      .catch(error => console.log(error));
    }
  }
}
</script>

<style scoped>

</style>