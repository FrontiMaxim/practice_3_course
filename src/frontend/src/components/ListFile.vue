<template>
  <div class="list-file" v-for="file in files" >
    <file key={{Date.now()}} :info-file="file" />
  </div>
</template>

<script>
import File from "@/components/File";
export default {
  components: {File},
  data() {
    return {
      files: [],
      url: '/api/files'
    }
  },

  methods: {

  },

  async mounted() {

    try {
      let response = await fetch(this.url);
      this.files = await response.json();
    } catch (error) {
      console.log(error);
    }

  }
}
</script>

<style scoped>

</style>