/*
    5种原始类型：
        number：数字（整数、小数、NaN(Not a Number)）
        string：字符串，单双引皆可
        boolean：布尔。true，false
        null：对象为空
        undefined：当声明的变量未初始化时，该变量的默认值是 undefined
    引用类型：JavaScript中也有对象，对象就是引用类型
        let date=new Date(),date就是一个引用类型对象。
 */
//1 定义number数字类型变量：（整数、小数、NaN(Not a Number)）
let number1 = 1
let number2 = 1.2
let number3 = NaN
console.log(number1, number2, number3, typeof number3);
//2 定义string字符串类型变量：单双引皆可
let string1 = "hello Js"
let string2 = 'hello JS'
console.log(string1, string2, typeof string1);
//3 定义boolean布尔类型变量：只有true/false两种取值
let T = true
let F = false
console.log(T, F, typeof F);
//4 定义null类型变量
let o = null

console.log(o, typeof o)
//5 定义undefined类型变量：当声明的变量未初始化时，该变量的默认值是undefined
let undef = undefined
console.log(undef, typeof undef);
//6 定义引用类型：JavaScript中也有对象，对象就是引用类型
let date = new Date();
console.log(date.getFullYear());
console.log(date);