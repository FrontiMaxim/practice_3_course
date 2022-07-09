<template>
  <div class="swbics" v-for="swbic in listSwbic">
    <div>{{swbic.swbic}}</div>
    <div>{{swbic.defaultSwibc}}</div>
  </div>
</template>

<script>
export default {
  name: 'my-swbics',
  props: {
    listSwbic: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>
.swbics {
  background: green;
}
</style>