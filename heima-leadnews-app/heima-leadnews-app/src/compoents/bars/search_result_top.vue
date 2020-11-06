<template>
    <div class="bar_bg">
        <text class="icon" @click="back">&#xf104;</text>
        <Search
                :icon="icon"
                @onSubmit="onSubmit"
                :value="value"
                :placeholder="placeholder"
                right-width="30"
                left-width="30" />
        <text class="icon" @click="home">&#xf00d;</text>
    </div>
</template>

<script>
    import Search from '@/compoents/inputs/search';
    export default {
        name: "search_top_bar",
        components: {Search},
        props : {
            value : {
                type:String,
                default:'12'
            },
            placeholder:{
                type:String,
                default:'请输入...'
            }
        },
        data(){
            return {
                icon:'\uF002'
            }
        },
        methods:{
            back : function(){
                this.$router.back()
            },
            home : function(){
                this.$router.push('/home');
            },
            onSubmit : function(val){
                this.$emit('onSubmit', val);
            }
        }
    }
</script>

<style lang="less" scoped>
    @import '../../styles/common';
    .bar_bg{
        width: @screen-width;
        flex-direction: row;
        background-color: @bg-white;
        border-style: solid;
        height: @top-height;
        padding: 10px 15px 5px 20px;
        align-items: center;
        background-color: #ffffff;
        }
    .icon{
        color: #dbdbdb;
        font-size: 42px;
    }
</style>
