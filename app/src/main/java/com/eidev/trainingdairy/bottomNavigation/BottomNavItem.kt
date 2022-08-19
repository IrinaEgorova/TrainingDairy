package com.eidev.trainingdairy.bottomNavigation

import com.eidev.trainingdairy.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object Dairy : BottomNavItem("Дневник", R.drawable.ic_dairy,"dairy")
    object Results: BottomNavItem("Результаты", R.drawable.ic_results,"results")
    object Exercise: BottomNavItem("Упражнения", R.drawable.ic_exercise,"exercise")
    object Settings: BottomNavItem("Настройки", R.drawable.ic_settings,"settings")
}