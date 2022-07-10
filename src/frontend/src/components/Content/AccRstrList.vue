<template>
  <div class="acc-rstr-list" v-for="accRstr in accRstrList">
    <h3 class="title">Перечень ограничений операций по счёту</h3>
    <div><strong>Код ограничения операций по счёту: </strong>{{accRstr.accRstr}}</div>
    <div><strong>Дата начала действия ограничения по счёту: </strong>{{accRstr.accRstrDate}}</div>
  </div>
</template>

<script>
export default {
  name: 'acc-rstr-list',
  props: {
    accRstrList: {
      type: Array,
      required: true
    }
  },

  data() {
    return {
      AccRstr: '',
      AccRstrDate: ''
    }
  }
}
</script>

<style scoped>

</style>