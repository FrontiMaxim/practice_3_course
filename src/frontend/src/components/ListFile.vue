<template>
  <div v-for="file in files" >
    <file key={{Date.now()}} :info-file="file" />
  </div>
</template>

<script>
import File from "@/components/File";
export default {
  props: {
    files: {
      type: Array,
      required: true
    }
  },

  components: {File},
}
</script>

<style scoped>

</style>