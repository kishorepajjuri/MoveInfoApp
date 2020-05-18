package com.micro.MovieInfoApp;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.io.FileInputStream;
import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.MovieInfoApp.dto.MovieResponse;
import com.micro.MovieInfoApp.service.MovieService;
import com.micro.MovieInfoApp.service.MovieServiceImpl;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@RestClientTest(MovieServiceImpl.class)
@PropertySource("classpath:application-test.properties")
public class MovieServiceTest {

	@Autowired
	private MockRestServiceServer mockServer;



	@Autowired
	private MovieServiceImpl empService;

	private static final ObjectMapper mapper = new ObjectMapper();

	private MovieResponse responseMovieResponseEntity;

	@Value("${service.url}")
	private String movieUrl;

	@SuppressWarnings("deprecation")
	@Test
	public void testWhenPhoneNumEnteredAndDataExists_thenReturnHttp200() throws Exception {
		System.out.println("Enter into test Method::::");
		int movieId = 1;
		final FileInputStream fileInputStream = new FileInputStream(
				ResourceUtils.getFile("classpath:response_http200.json"));
		final String staticResponse = StreamUtils.copyToString(fileInputStream, Charset.defaultCharset());

		MovieResponse mockInvoiceResponse = mapper.readValue(staticResponse, MovieResponse.class);

		this.mockServer.expect(ExpectedCount.once(), requestTo(movieUrl + movieId))
				.andExpect(MockRestRequestMatchers.method(HttpMethod.GET)).andRespond(withStatus(HttpStatus.OK)
						.contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(mockInvoiceResponse)));

		responseMovieResponseEntity = empService.getMovieInformation(movieId);
		mockServer.verify();

		Assert.assertEquals("success", responseMovieResponseEntity.getStatus());

	}

}
