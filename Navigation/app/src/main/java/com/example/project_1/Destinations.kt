package com.example.project_1

interface Destinations
{
    val route:String
}
object Home:Destinations
{
    override val route="Home"
}
object MenuList:Destinations
{
    override val route="MenuList"
}
object Dashboard:Destinations
{
    override val route="Dashboard"
}
object Details:Destinations
{
    override val route="Details"
}