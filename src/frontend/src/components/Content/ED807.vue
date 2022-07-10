<template>
  <div class="ed807">
    <div><strong>Номер ЭС в течении опередня: </strong> {{this.ed807.edNo}}</div>
    <div><strong>Уникальный идентификатор составителя ЭС: </strong> {{this.ed807.edAuthor}}</div>
    <div><strong>Дата составления ЭС: </strong> {{this.ed807.edDate}}</div>
    <div><strong>Код причины формирования: </strong> {{this.ed807.creationReason}}</div>
    <div><strong>Дата и время создания ЭС: </strong> {{this.ed807.creationDateTime}}</div>
    <div><strong>Вид представления информации: </strong> {{this.ed807.infoTypeCode}}</div>
    <div><strong>Да ОД, к которой относятся данные справочника БИК: </strong> {{this.ed807.businessDay}}</div>
    <div><strong>Номер версии справочника БИК в течении операционного дня: </strong> {{this.ed807.directoryVersion}}</div>
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
  padding-left: 10px;
}
</style>