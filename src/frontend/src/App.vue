<template>
  <div class="app">
    <dialog-import />
    <list-file />
    <div v-if="$store.state.content !== '' ">
      <my-content :content="$store.state.content" />
    </div>
  </div>
</template>

<script>
import DialogImport from "@/components/DialogImport";
import ListFile from "@/components/ListFile";
import Ed807 from "@/components/Content/ED807";
import MyContent from "@/components/Content/Content";


export default {

  components: {
    MyContent,
    Ed807,
    ListFile,
    DialogImport
  },
}
</script>

<style>
  * {
    padding: 0;
    margin: 0;
  }

  .app {
    width: 100vw;
    height: 100vh;
  }
</style>