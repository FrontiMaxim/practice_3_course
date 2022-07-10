<template>
  <div class="rstr-list" v-for="rstr in listRstr">
    <h3 class="title">Перечень ограничений участника</h3>
    <div><strong>Код ограничения, наложенного на участника: </strong>{{rstr.rstr}}</div>
    <div><strong>Дата начала действия ограничения участника: </strong>{{rstr.rstrDate}}</div>
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

</style>