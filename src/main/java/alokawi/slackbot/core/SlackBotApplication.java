package alokawi.slackbot.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "me.ramswaroop.jbot", "alokawi.slackbot.core.bot" })
public class SlackBotApplication {

	/**
	 * Entry point of the application. Run this method to start the sample bots,
	 * but don't forget to add the correct tokens in application.properties
	 * file.
	 *
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(SlackBotApplication.class, args);
	}
}