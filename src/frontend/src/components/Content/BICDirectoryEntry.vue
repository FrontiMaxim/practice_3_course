<template>
  <div class="bic" v-for="bic in listBic">
    <h3 class="title">Запись в справочнике БИК</h3>
    <div><strong>БИК: </strong>{{bic.bic}}</div>
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
  border: 5px dashed #c4cdd3;
  margin: 10px 5px 30px 5px;
  padding: 5px;
  border-radius: 10px;
}
</style>