<template>
  <div>
    <ed-807 :ed807="this.content.ed807" />
  </div>
</template>

<script>
import Ed807 from "@/components/Content/ED807";
export default {
  name: 'my-content',
  components: {Ed807},
  props: {
    content: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>

</style>