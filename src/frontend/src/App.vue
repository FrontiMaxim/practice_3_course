<template>
  <div class="app">
    <dialog-import
        :is-open="isOpenDialogImport"
        @sendingFile="isOpenDialogImport = false; isEndLoading = false"
        @updateListFiles="fetchGetFiles"
        @cancelSave="isOpenDialogImport = false"
    />
    <div>
      <h3 class="title-content">Содержимое файла:</h3>
      <div class="container-content" >
        <my-content :content="$store.state.content"  v-if="$store.state.content !== ''  && !$store.state.isLoadingContent"/>
        <img v-if="$store.state.isLoadingContent" src="https://s2.svgbox.net/loaders.svg?ic=elastic-spinner&color=000000" width="50" height="50">
      </div>
    </div>
    <div class="list-file">
      <h3 class="title-content">Файлы:</h3>
      <button class="btn-add-file" @click="openDialogImport">
        <span v-if="isEndLoading" >
          <img src="https://s2.svgbox.net/hero-outline.svg?ic=plus-sm&color=000000" width="20" height="20">
          Импортировать файл
        </span>
        <img v-else src="https://s2.svgbox.net/loaders.svg?ic=elastic-spinner&color=000000" width="20" height="20">
      </button>
      <div>
        <list-file :files="files"/>
      </div>
    </div>
  </div>
</template>

<script>
import DialogImport from "@/components/DialogImport";
import ListFile from "@/components/ListFile";
import Ed807 from "@/components/Content/ED807";
import MyContent from "@/components/Content/Content";


export default {

  data() {
    return {
      files: [],
      isOpenDialogImport: false,
      isEndLoading: true
    }
  },

  components: {
    MyContent,
    Ed807,
    ListFile,
    DialogImport
  },

  methods: {
    openDialogImport() {
      this.isOpenDialogImport = true;
    },

    async fetchGetFiles() {

      this.isEndLoading = true;

      try {
        let response = await fetch('/api/files');
        this.files = await response.json();
      } catch (error) {
        console.log(error);
      }
    }
  },

  mounted() {
    this.fetchGetFiles();
  }
}
</script>

<style>
  * {
    padding: 0;
    margin: 0;
  }

  .app {
    display: flex;
    justify-content: space-around;
    align-items: center;
    overflow: hidden;
    width: 100vw;
    height: 100vh;
  }

  .container-content {
    overflow: auto;
    width: 50vw;
    height: 85vh;
    box-shadow: 0 0 10px #000;
    padding: 5px;
  }

  .container-content img {
    display: block;
    margin: 35% auto ;
  }

  .title-content {
    background: #c4cdd3;
    margin-bottom: 10px;
    padding: 5px 15px;
  }

  .list-file {
    padding: 10px;
    width: 35vw;
    height: 92vh;
    overflow: auto;
  }

  .title {
    background: #c4cdd3;
  }

  .btn-add-file {
    background: #c4cdd3;
    border: none;
    padding: 0 3px;
    font-weight: bold;
    cursor: pointer;
    box-shadow: 0 0 3px #000;
    margin-bottom: 15px;
  }

  .btn-add-file:hover {
    box-shadow: 0 0 5px #000;
  }

  .btn-add-file span {
    display: flex;
    align-items: center;
  }
</style>