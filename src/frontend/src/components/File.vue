<template>
  <div class="file" @click="fetchGetFile">
    <div class="left-path-file">
      <img src="https://s2.svgbox.net/hero-outline.svg?ic=document&color=000000" width="30" height="30">
      <span><strong>{{nameFile}}</strong></span>
    </div>
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
      nameFile: this.infoFile.nameFile,
    }
  },

  methods: {
    async fetchGetFile($event) {

      if(this.$store.state.activeFile) {
        this.$store.state.activeFile.style['background-color']  = '#ffffff';
      }

      this.$store.commit('changeActiveFile', $event.currentTarget);
      this.$store.state.activeFile.style['background-color'] = '#c4cdd3';

      try {
        this.$store.commit('changeIsLoadingContent', true);
        let response = await fetch(`/api/file/${this.idFile}`);
        let data = await response.json();
        this.$store.commit('changeContent', data);
        this.$store.commit('changeIsLoadingContent', false);
      } catch (error) {
        console.log(error);
      }
    }
  }
}
</script>

<style scoped>
.file {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 10px;
  min-width: 80%;
  height: 40px;
  box-shadow: 0 0 5px #000;
  margin-bottom: 15px;
  cursor: pointer;
}

.file:hover {
  background: #c4cdd3 ;
}

.left-path-file {
  display: flex;
  justify-content: center;
  align-items: center;
}

.left-path-file span {
  margin-left: 10px;
}
</style>