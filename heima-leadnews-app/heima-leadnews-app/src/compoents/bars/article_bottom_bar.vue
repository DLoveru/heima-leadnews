<template>
    <div class="bar_bg">
        <Search rightWidth=25 />
        <text class="icon">&#xf075;</text>
        <text @click="clickCollection" class="icon" :style="{color:collection?'red':'#bdbdbd'}">&#xf005;</text>
        <text @click="clickForward" class="icon" :style="{color:forward?'red':'#bdbdbd'}">&#xf14d;</text>
    </div>
</template>

<script>
    import Search from '@/compoents/inputs/search';
    export default {
        name: "article_bottom_bar",
        components: {Search},
        props:{
            collection:{
                type:Boolean,
                default:false
            },
            forward:{
                type:Boolean,
                default:false
            }
        },
        methods:{
            clickCollection : function(){
                this.$emit("clickCollection",{})
            },
            clickForward : function(){
                this.$emit("clickForward",{})
            }
        }
    }
</script>

<style lang="less" scoped>
    @import '../../styles/common';
    .bar_bg{
        width: @screen-width;
        flex-direction: row;
        align-items:center;
        border-width:1px;
        border-color: @border-color;
        background-color: @bg-white;
        border-style: solid;
        height: @top-height;
        padding-top: 4px;
        padding-left: 5px;
    }
    .icon{
        color: @border-color;
        font-size: 48px;
        width: 80px;
    }
</style>
