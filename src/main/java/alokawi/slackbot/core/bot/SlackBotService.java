/**
 * 
 */
package alokawi.slackbot.core.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import me.ramswaroop.jbot.core.slack.Bot;
import me.ramswaroop.jbot.core.slack.Controller;
import me.ramswaroop.jbot.core.slack.EventType;
import me.ramswaroop.jbot.core.slack.models.Event;
import me.ramswaroop.jbot.core.slack.models.Message;

/**
 * @author alokkumar
 *
 */
@Component
public class SlackBotService extends Bot {
	private static final Logger logger = LoggerFactory.getLogger(SlackBotService.class);

	/**
	 * Slack token from application.properties file. You can get your slack
	 * token next <a href="https://my.slack.com/services/new/bot">creating a new
	 * bot</a>.
	 */
	@Value("${slackBotToken}")
	private String slackToken;

	@Override
	public String getSlackToken() {
		return slackToken;
	}

	@Override
	public Bot getSlackBot() {
		return this;
	}

	/**
	 * Invoked when the bot receives a direct mention (@botname: message) or a
	 * direct message. NOTE: These two event types are added by jbot to make
	 * your task easier, Slack doesn't have any direct way to determine these
	 * type of events.
	 *
	 * @param session
	 * @param event
	 */
	@Controller(events = { EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE })
	public void onReceiveDM(WebSocketSession session, Event event) {
		logger.info("Slack message recieved : " + event.getText());
		reply(session, event, new Message("> Received your message : " + event.getText()));
	}

}
