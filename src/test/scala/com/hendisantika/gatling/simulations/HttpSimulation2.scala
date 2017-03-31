package com.hendisantika.gatling.simulations.simulations

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

import scala.concurrent.duration._
/**
  * Created by hendisantika on 17/02/17.
  */
class HttpSimulation2 extends Simulation{
  val theHttpProtocolBuilder = http
    .baseURL("http://computer-database.gatling.io")

  /*
   * This scenario consists of two GET requests; one to the base URL and one to /computers relative
   * to the base URL.
   * Between the requests there will be a pause for five seconds.
   * Note that in order to get access to different durations, we must add the following import:
   * import scala.concurrent.duration._
   */
  val theScenarioBuilder = scenario("Scenario1")
    .exec(
      http("GET to base URL")
        .get("/"))
    .pause(1, 5 seconds)
    .exec(
      http("GET to /computers")
        .get("/computers"))

  setUp(
    theScenarioBuilder.inject(atOnceUsers(1))
  ).protocols(theHttpProtocolBuilder)

}
