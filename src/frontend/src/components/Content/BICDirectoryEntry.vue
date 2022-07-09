<template>
  <div class="bic" v-for="bic in listBic">
    <div>{{bic.bic}}</div>
    <participant-info :participant-info="bic.participantInfo" />
    <my-accounts :list-accounts="bic.listAccount" />
    <my-swbics :list-swbic="bic.listSwbic" />
  </div>
</template>

<script>
import ParticipantInfo from "@/components/Content/ParticipantInfo";
import MyAccounts from "@/components/Content/Accounts";
import MySwbics from "@/components/Content/SWBICS";
export default {
  name: 'my-bic',
  components: {MySwbics, MyAccounts, ParticipantInfo},
  props: {
    listBic: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>
.bic {
  background: burlywood;
}
</style>