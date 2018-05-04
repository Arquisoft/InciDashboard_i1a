package com.uniovi.asw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uniovi.asw.entities.Agent;
import com.uniovi.asw.entities.Incident;
import com.uniovi.asw.entities.Incident.IncidentStatus;
import com.uniovi.asw.entities.Message;
import com.uniovi.asw.entities.Operator;
import com.uniovi.asw.parser.IncidentDeserializer;
import com.uniovi.asw.util.LatLng;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityTests {
	// Agents
	@Test
	public void PR01() {
		Agent agent = new Agent("500b", "alejandro", "123456", "23.273425,-15.694777");
		agent.setKind(0);
		agent.setEmail("alex@mail.com");
		Assert.assertEquals(agent.toString(),
				"Agent [idautogenerado='500b', name='alejandro', email='alex@mail.com', "
				+ "password='123456', location='23.273425,-15.694777', id='null', kind=0]");
		Assert.assertFalse(agent.equals(null));
		String[] data = { "alejandro", "alex@mail.com", "123456", "23.273425,-15.694777", "500b", "0" };
		Agent agent2 = new Agent(data);
		Assert.assertFalse(agent.equals(agent2));
		Operator op = new Operator("police", "police");
		Assert.assertFalse(agent.equals(op));
		agent.setIdautogenerado("a");
		Assert.assertFalse(agent.equals(agent2));
		agent.setIdautogenerado(agent2.getIdautogenerado());
		Assert.assertEquals(agent2.getIdautogenerado(), agent.getIdautogenerado());
		Assert.assertTrue(agent.getKind() == 0);
		agent.setKind(1);
		Assert.assertFalse(agent.equals(agent2));
		agent.setKind(0);
		agent.setId("125L");
		Assert.assertEquals("125L", agent.getId());
		Assert.assertFalse(agent.equals(agent2));
		agent.setId("500b");
		Assert.assertTrue(agent.equals(agent2));
		agent.setEmail("alejandro@mail.com");
		Assert.assertEquals("alejandro@mail.com", agent.getEmail());
		Assert.assertFalse(agent.equals(agent2));
		agent.setEmail("alex@mail.com");
		Assert.assertTrue(agent.equals(agent2));
		agent.setName("fernando");
		Assert.assertEquals("fernando", agent.getName());
		Assert.assertFalse(agent.equals(agent2));
		agent.setName("alejandro");
		Assert.assertTrue(agent.equals(agent2));
		Assert.assertEquals("alejandro", agent.getName());
		Assert.assertEquals("123456", agent.getPassword());
		agent.setPassword("contraseñasegura");
		Assert.assertFalse(agent.equals(agent2));
		Assert.assertEquals("contraseñasegura", agent.getPassword());
		agent.setPassword("123456");
		Assert.assertTrue(agent.equals(agent2));
		Assert.assertEquals("23.273425,-15.694777", agent.getLocation());
		agent.setLocation("26.25,-10.77");
		Assert.assertFalse(agent.equals(agent2));
		Assert.assertEquals("26.25,-10.77", agent.getLocation());
		agent.setLocation("23.273425,-15.694777");
		Assert.assertTrue(agent.equals(agent2));
	}

	// Operators
	@Test
	public void PR02() {
		Operator op = new Operator("firestation", "firestation");
		Agent ag = new Agent("500b", "alejandro", "123456", "23.273425,-15.694777");
		Assert.assertNotEquals(op, ag);
		Assert.assertFalse(op.equals(null));
		Operator op2 = new Operator("firestation", "firestation");
		int hash1 = op.hashCode();
		Assert.assertEquals(hash1, op2.hashCode());
		Assert.assertTrue(op.equals(op2));
		Assert.assertEquals("firestation", op.getUsername());
		op.setUsername(null);
		Assert.assertFalse(op.equals(op2));
		op2.setUsername(null);
		Assert.assertTrue(op.equals(op2));
		op.setUsername("policeman");
		op2.setUsername("policeman");
		Assert.assertNotEquals(hash1, op.hashCode());
		Assert.assertEquals("policeman", op.getUsername());
		Assert.assertEquals("firestation", op.getPassword());
		op.setPassword(null);
		Assert.assertFalse(op.equals(op2));
		op2.setPassword(null);
		Assert.assertTrue(op.equals(op2));
		op.setPassword("policeman");
		Assert.assertFalse(op.equals(op2));
		op2.setPassword("policeman");
		Assert.assertTrue(op.equals(op2));
		Assert.assertEquals("policeman", op.getPassword());
		op.setId(100L);
		op2.setId(101L);
		op.setUsername(null);
		op.setPassword(null);
		Assert.assertEquals(31 * 31, op.hashCode());
		op.setPassword(op2.getPassword());
		Assert.assertNotEquals(op2, op);
	}

	// Incidents
	@Test
	public void PR03() {
		Agent agent = new Agent("700c", "pablo", "pablo", "25.0,25.0");
		Operator op = new Operator("fireman", "fireman");
		Operator op2 = new Operator("policeman", "policeman");
		Incident incident = createIncident(agent, op, "Fire", "Fire spotted in the woods", 25.0, 25.0);

		Assert.assertTrue(incident.isAssignedTo(op.getUsername()));
		Assert.assertFalse(incident.isAssignedTo(op2.getUsername()));
		incident.setIncidentName("Not fire");
		Assert.assertNotEquals("Fire", incident.getIncidentName());
		Assert.assertEquals("Not fire", incident.getIncidentName());

		Assert.assertEquals("Fire spotted in the woods", incident.getDescription());
		incident.setDescription("Not fire, it was actually a bird");
		Assert.assertNotEquals("Fire spotted in the woods", incident.getDescription());
		Assert.assertEquals("Not fire, it was actually a bird", incident.getDescription());

		Assert.assertTrue(incident.getAditionalProperties().containsKey("p1"));
		Map<String, String> newProperties = new HashMap<String, String>();
		newProperties.put("p2", "property2");
		incident.setAditionalProperties(newProperties);
		Assert.assertFalse(incident.getAditionalProperties().containsKey("p1"));
		Assert.assertTrue(incident.getAditionalProperties().containsKey("p2"));

		Assert.assertEquals(incident.getAgent(), agent);
		Agent carolina = new Agent("300z", "carolina", "contraseña", "30.0,30.0");
		incident.setAgent(carolina);
		Assert.assertNotEquals(incident.getAgent(), agent);
		Assert.assertEquals(incident.getAgent(), carolina);

		Date newdate = new Date();
		incident.setDate(newdate);
		Assert.assertEquals(newdate, incident.getDate());

		Assert.assertTrue(25.0 == incident.getLocation().getLat());
		Assert.assertTrue(25.0 == incident.getLocation().getLng());
		incident.setLocation(new LatLng(30.0, 30.0));
		Assert.assertTrue(30.0 == incident.getLocation().getLat());
		Assert.assertTrue(30.0 == incident.getLocation().getLng());

		Assert.assertEquals(incident.getOperator(), op);
		Operator francisco = new Operator("francisco", "francisco");
		incident.setOperator(francisco);
		Assert.assertEquals(incident.getOperator(), francisco);

		IncidentStatus status = Collections.unmodifiableList(Arrays.asList(IncidentStatus.values())).get(0);
		Assert.assertEquals(status, incident.getStatus());
		IncidentStatus status2 = Collections.unmodifiableList(Arrays.asList(IncidentStatus.values())).get(1);
		incident.setStatus(status2);
		Assert.assertEquals(status2, incident.getStatus());

		Assert.assertTrue(incident.getTags().contains("tag"));
		Assert.assertTrue(incident.getTags().size() == 1);
		List<String> newtags = new ArrayList<String>();
		newtags.add("newtag1");
		newtags.add("newtag2");
		incident.setTags(newtags);
		Assert.assertTrue(incident.getTags().contains("newtag1"));
		Assert.assertTrue(incident.getTags().contains("newtag2"));
		Assert.assertFalse(incident.getTags().contains("tag"));
		Assert.assertTrue(incident.getTags().size() == 2);

		Assert.assertEquals("FIRE", incident.getTopic());
		incident.setTopic("ACCIDENT");
		Assert.assertNotEquals("FIRE", incident.getTopic());
		Assert.assertEquals("ACCIDENT", incident.getTopic());

		incident.setAditionalPropertiesString("");
		Assert.assertEquals(incident.getAditionalPropertiesString(), "");
		incident.setLocationString("Asturias");
		Assert.assertEquals("Asturias", incident.getLocationString());
	}

	// Messages
	@Test
	public void PR04() {
		Message msg1 = new Message("fire", "FIRE");
		Assert.assertNotEquals(msg1, null);
		Assert.assertEquals(msg1, msg1);
		Operator op = new Operator("fireman", "fireman");
		Assert.assertNotEquals(msg1, op);
		Message msg2 = new Message("fire", "FIRE");
		Assert.assertEquals(msg1, msg2);
		Assert.assertEquals(msg1.hashCode(), msg2.hashCode());
		Assert.assertEquals("fire", msg1.getMessage());
		Assert.assertEquals("FIRE", msg1.getTopic());
		Message msg3 = new Message("accident", "ACCIDENT");
		Assert.assertNotEquals(msg1, msg3);
		Message msg4 = new Message();
		Assert.assertEquals(31 * 31, msg4.hashCode());
		Assert.assertNotEquals(msg4, msg1);
		Message msg8 = new Message(null, null);
		Assert.assertEquals(msg4, msg8);
		Message msg5 = new Message("accident", null);
		Assert.assertNotEquals(msg5, msg3);
		Message msg6 = new Message("accident", null);
		Assert.assertEquals(msg5, msg6);
		Message msg7 = new Message("accident", "NOT_ACCIDENT");
		Assert.assertNotEquals(msg7, msg3);
	}

	// LatLng
	@Test
	public void PR05() {
		LatLng ll1 = new LatLng(25.0, 25.0);
		LatLng location2 = new LatLng(25.0, 25.0);
		Assert.assertEquals(ll1.hashCode(), location2.hashCode());
		Assert.assertTrue(ll1.equals(ll1));
		Assert.assertFalse(ll1.equals(new Object()));
		Assert.assertNotEquals(ll1, null);
		LatLng ll2 = new LatLng(25.0, 25.0);
		Assert.assertEquals(ll1, ll2);
		Assert.assertTrue(25.0 == ll1.getLat());
		ll1.setLat(24.0);
		Assert.assertTrue(24.0 == ll1.getLat());
		Assert.assertFalse(25.0 == ll1.getLat());
		Assert.assertNotEquals(ll1, ll2);
		ll1.setLat(25.0);
		Assert.assertEquals(ll1, ll2);
		Assert.assertTrue(25.0 == ll1.getLng());
		ll1.setLng(24.0);
		Assert.assertTrue(24.0 == ll1.getLng());
		Assert.assertNotEquals(ll1, ll2);
	}

	// IncidentDeserializer
	@Test
	public void PR06() {
		IncidentDeserializer id = new IncidentDeserializer();
		id.configure(null, false);
		Incident i = id.deserialize("FIRE", null);
		Assert.assertEquals(i, null);
		id.close();
	}

	private Incident createIncident(Agent agent, Operator op, String name, String desc, double lat, double lng) {
		LatLng location = new LatLng(lat, lng);
		Date date = new Date(2500);
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("tag");
		Map<String, String> additionalProperties = new HashMap<String, String>();
		additionalProperties.put("p1", "property");
		String topic = "FIRE";
		List<IncidentStatus> values = Collections.unmodifiableList(Arrays.asList(IncidentStatus.values()));
		IncidentStatus status = values.get(0);

		return new Incident(agent, name, desc, location, date, tags, additionalProperties, topic, status, op);

	}
}