<template>
  <div class="accounts" v-for="account in listAccounts">
    <h3 class="title">Информацияо счетах участника перевода денежных средств</h3>
    <div><strong>Номер счёта: </strong>{{account.account}}</div>
    <div><strong>Тип счёта в соответствии с нормативами: </strong>{{account.regulationAccountType}}</div>
    <div><strong>Контрольный ключ: </strong>{{account.ck}}</div>
    <div><strong>БИК ПБР, обслуживающего счёт участника перевода: </strong>{{account.accountCbrbic}}</div>
    <div><strong>Дата открытия счёта: </strong>{{account.dateIn}}</div>
    <div><strong>Статус счёта: </strong>{{account.accountStatus}}</div>

    <acc-rstr-list :acc-rstr-list="account.listAccRstrList" />
  </div>
</template>

<script>
import AccRstrList from "@/components/Content/AccRstrList";
export default {
  name: 'my-accounts',
  components: {AccRstrList},
  props: {
    listAccounts: {
      type: Array,
      required: true
    }
  },
  data() {
    return {
      Account: '',
      RegulationAccountType: '',
      CK: '',
      AccountCBRBIC: '',
      DateIn: '',
      AccountStatus: ''
    }
  }
}
</script>

<style scoped>

</style>