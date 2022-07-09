<template>
  <div class="rstr-list" v-for="rstr in listRstr">
    <div>{{rstr.rstr}}</div>
    <div>{{rstr.rstrDate}}</div>
  </div>
</template>

<script>
export default {
  name: "rstr-list",
  props: {
    listRstr: {
      type: Array,
      required: true
    }
  },
  data() {
    return {
      Rstr: '',
      RstrDate: ''
    }
  }
}
</script>

<style scoped>
.rstr-list {
  background: red;
}
</style>