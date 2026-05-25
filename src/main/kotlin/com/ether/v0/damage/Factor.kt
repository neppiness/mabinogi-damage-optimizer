package com.ether.v0.damage

// 이 인터페이스가 반드시 필요한 것인지...
// 계산식을 공통으로 쓸 수 있으면 좋겠는데 그러려면 어떤 식으로 묶는 게 좋을지...
interface Factor {
    fun calculate(): Double
}
