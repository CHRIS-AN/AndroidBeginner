package re.sta.rt.Kotlin

/*
2) 은행 계좌 만들기
- 계좌 생성 기능 ( 이름, 생년 월일, 초기 금액 )
- 잔고를 확인 기능
- 출금 기능
- 예금 기능
 */

fun main(array: Array<String>) {
    val account : Account = Account("정민안", "1992.09.11", 1000)
    println(account.checkBalance())
    println(account.save(10000))
    println(account.withdraw(2031))
    println(account.checkBalance())

    val account2 : Account = Account("홍길동","1992.09.11.", -1000)
    println(account2.checkBalance())

    val account3 : Account2 = Account2("과연", "1992.09.22")
    println(account3.checkBalance())
}

class Account {
    val name : String
    val birth : String
    var balance : Int

    constructor(name: String, birth: String, balance: Int) {
        this.name = name
        this.birth = birth
        if(balance >=0) {
            this.balance = balance
        }else {
            this.balance = 0
        }
        //this.balance = balance
    }


    // 잔고 확인
    fun checkBalance() : Int {
        return balance
    }

    // (출금하려고하는 금액 : amount)
    fun withdraw(amount : Int) : Boolean {
        if(balance >= amount) {
             balance -= amount
            return true
        }else {
            return false
        }
    }

    fun  save(amount : Int) {
        balance += amount
    }
}

class Account2 (val name : String, val birth : String, var balance : Int = 1000  ) {
    // 잔고 확인

    fun checkBalance() : Int {
        return balance
    }

    // (출금하려고하는 금액 : amount)
    fun withdraw(amount : Int) : Boolean {
        if(balance >= amount) {
            balance -= amount
            return true
        }else {
            return false
        }
    }

    fun  save(amount : Int) {
        balance += amount
    }
}


class Account3(initialBalance : Int) {

    val balance : Int = if (initialBalance >= 0 ) initialBalance else 0
    fun checkBalance() : Int {
        return balance
    }
}














