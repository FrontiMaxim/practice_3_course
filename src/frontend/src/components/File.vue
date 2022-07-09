<template>
  <div class="file" @click="fetchGetFile">
    <span>{{nameFile}}</span>
    <button class="btn-file-delete">Удалить</button>
  </div>
</template>

<script>
export default {
  props: {
    infoFile: {
      type: Object,
      required: true
    }
  },

  data() {
    return {
      idFile: this.infoFile.idFile,
      nameFile: this.infoFile.nameFile
    }
  },

  methods: {
    async fetchGetFile() {
      try {
        let response = await fetch(`/api/file/${this.idFile}`);
        let data = await response.json();
        this.$store.commit('changeContent', data);
      } catch (error) {
        console.log(error);
      }
    }
  }
}
</script>

<style scoped>

</style>