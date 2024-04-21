package za.co.aboutblank.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static za.co.aboutblank.consts.Errors.SCORE_OVER_LIMITS;
import static za.co.aboutblank.consts.Words.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HandControllerFunctionalTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    // Basic "happy path test"
    @Test
    public void canCalculateHappyPathTest() {
        var input = "SA,C10,DK,HK,HQ";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains(ONE_PAIR);
    }

    @Test
    public void canCalculateRoyalFlagTest() {
        var input = "SA,SQ,SJ,SK,S10";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains(ROYAL_FLUSH);
    }

    @Test
    public void canCalculateFiveOfKindTest() {
        var input = "SA,CA,DA,j,HA";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains(FIVE_OF_KIND);
    }

    @Test
    public void canCalculateStraightFlushTest() {
        var input = "CJ,C10,C9,C8,C7";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains(STRAIGHT_FLUSH);
    }

    @Test
    public void canCalculateFourOfKindTest() {
        var input = "C5,D5,H5,S5,H2";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains(FOUR_OF_KIND);
    }

    @Test
    public void canCalculateFullHouseTest() {
        var input = "S6,H6,D6,CK,HK";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains(FULL_HOUSE);
    }

    @Test
    public void canCalculateFlushTest() {
        var input = "DJ,D9,D8,D4,D3";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains(FLUSH);
    }

    @Test
    public void canCalculateStraightTest() {
        var input = "D10,S9,H8,D7,C6";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains(STRAIGHT);
    }

    @Test
    public void canCalculateThreeOfKindTest() {
        var input = "CQ,SQ,HQ,H9,S2";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains(THREE_OF_KIND);
    }

    @Test
    public void canCalculateTwoPairTest() {
        var input = "HJ,SJ,C3,S3,H2";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains(TWO_PAIRS);
    }

    @Test
    public void canCalculateOnePairTest() {
        var input = "SA,C10,DK,HK,HQ";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains("You have 1 pair");
    }

    @Test
    public void canCalculateHighestCardTest() {
        var input = "DK,DQ,S7,S4,H3";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains(HIGHEST_CARD);
    }

    @Test
    public void canWorkWithSpacesTest() {
        var input = "DK, CQ , S7 , S10 , H3";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains(HIGHEST_CARD);
    }

    @Test
    public void canHandleInvalidValuesTest() {
        var input = " DK, DQ, S77, S4, H3";

        assertThat(this.restTemplate.getForObject(
                "http://localhost:" + port + "/hand?cards=" + input,
                String.class))
                .contains(SCORE_OVER_LIMITS);
    }
}