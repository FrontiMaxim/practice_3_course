<template>
  <div class="participant-info">
    <h3 class="title">Информация об участнике входящего в справочник БИК</h3>
    <div><strong>Наименование участника: </strong>{{participantInfo.nameP}}</div>
    <div><strong>Код страны: </strong>{{participantInfo.cntrCd}}</div>
    <div><strong>Код территории: </strong>{{participantInfo.rgn}}</div>
    <div><strong>Индекс: </strong>{{participantInfo.ind}}</div>
    <div><strong>Тип населённого пункта: </strong>{{participantInfo.tnp}}</div>
    <div><strong>Наименование населённого пункта: </strong>{{participantInfo.nnp}}</div>
    <div><strong>Адрес: </strong>{{participantInfo.adr}}</div>
    <div><strong>Дата включения в состав участников перевода: </strong>{{participantInfo.dateIn}}</div>
    <div><strong>Тип участника перевода: </strong>{{participantInfo.ptType}}</div>
    <div><strong>Доступные сервисы перевода денежных средств: </strong>{{participantInfo.srvcs}}</div>
    <div><strong>УИС: </strong>{{participantInfo.uid}}</div>
    <div><strong>Тип участника перевода: </strong>{{participantInfo.ptType}}</div>
    <div><strong>Участник обмена: </strong>{{participantInfo.xchType}}</div>
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

</style>