<template>
  <div class="acc-rstr-list" v-for="accRstr in accRstrList">
    <div>{{accRstr.accRstr}}</div>
    <div>{{accRstr.accRstrDate}}</div>
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
.acc-rstr-list {
  background: yellow;
}
</style>