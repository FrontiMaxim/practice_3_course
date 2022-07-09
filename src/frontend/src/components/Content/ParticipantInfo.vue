<template>
  <div class="participant-info">
    <div>{{participantInfo.nameP}}</div>
    <div>{{participantInfo.regN}}</div>
    <div>{{participantInfo.cntrCd}}</div>
    <div>{{participantInfo.rgn}}</div>
    <div>{{participantInfo.ind}}</div>
    <div>{{participantInfo.tnp}}</div>
    <div>{{participantInfo.nnp}}</div>
    <div>{{participantInfo.adr}}</div>
    <div>{{participantInfo.dateIn}}</div>
    <div>{{participantInfo.ptType}}</div>
    <div>{{participantInfo.srvcs}}</div>
    <div>{{participantInfo.uid}}</div>
    <div>{{participantInfo.ptType}}</div>
    <div>{{participantInfo.participantStatus}}</div>
    <rstr-list :list-rstr="participantInfo.listRstrList" />
  </div>
</template>

<script>
import RstrList from "@/components/Content/RstrList";
export default {
  name: 'participant-info',
  components: {RstrList},
  props: {
    participantInfo: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>
.participant-info {
  background: darkgrey;
}
</style>