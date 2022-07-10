<template>
  <div class="swbics" v-for="swbic in listSwbic">
    <h3 class="title">Перечень БИК (СВИФТ)</h3>
    <div><strong>БИК (СВИФТ): </strong>{{swbic.swbic}}</div>
    <div><strong>Признак использования БИК (СВИФТ): </strong>{{swbic.defaultSwbic}}</div>
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

</style>