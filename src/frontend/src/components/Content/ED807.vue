<template>
  <div class="ed807">
    <div>{{this.ed807.edNo}}</div>
    <div>{{this.ed807.eDAuthor}}</div>
    <div>{{this.ed807.eDDate}}</div>
    <div>{{this.ed807.creationReason}}</div>
    <div>{{this.ed807.creationDateTime}}</div>
    <div>{{this.ed807.infoTypeCode}}</div>
    <div>{{this.ed807.businessDay}}</div>
    <div>{{this.ed807.directoryVersion}}</div>
  </div>
  <my-bic :list-bic="this.ed807.listBicDirectoryEntry" />
</template>

<script>
import ParticipantInfo from "@/components/Content/ParticipantInfo";
import MyBic from "@/components/Content/BICDirectoryEntry";
export default {
  name: "ed-807",
  components: {MyBic, ParticipantInfo},
  props: {
    ed807: {
      type: Object,
      required: true
    }
  },

}
</script>

<style scoped>
.ed807 {
  background: aqua;
}
</style>