<template>
  <div class="accounts" v-for="account in listAccounts">
    <div>{{account.account}}</div>
    <div>{{account.regulationAccountType}}</div>
    <div>{{account.ck}}</div>
    <div>{{account.accountCbrbic}}</div>
    <div>{{account.dateIn}}</div>
    <div>{{account.accountStatus}}</div>

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
.accounts {
  background: blue;
}
</style>