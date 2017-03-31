package com.hendisantika.gatling.simulations.simulations

import com.hendisantika.gatling.simulations.common.HttpSimulationBaseClass

import scala.concurrent.duration._

/**
  * Created by hendisantika on 17/02/17.
  */
class HttpSimulation8 extends HttpSimulationBaseClass{
  scenario1BaseURL = "http://computer-database.gatling.io"
  scenario1RequestPath = "computers"
  finalUserCount = 4
  userCountRampUpTime = (5 seconds)

}
