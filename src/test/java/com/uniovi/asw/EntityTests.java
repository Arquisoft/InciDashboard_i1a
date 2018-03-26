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
import com.uniovi.asw.util.LatLng;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityTests {
	// Agents
	@Test
	public void PR01() {
		Agent agent = new Agent("alejandro", "123456", "23.273425,-15.694777");
		Assert.assertFalse(agent.equals(null));
		Agent agent2 = new Agent("alejandro", "123456", "23.273425,-15.694777");
		Assert.assertTrue(agent.equals(agent2));
		agent.setId("125L");
		Assert.assertEquals("125L", agent.getId());
		agent.setEmail("alejandro@mail.com");
		Assert.assertEquals("alejandro@mail.com", agent.getEmail());
		agent.setKind(0);
		Assert.assertTrue(agent.getKind() == 0);
		agent2.setName("fernando");
		Assert.assertFalse(agent.equals(agent2));
		Assert.assertEquals("alejandro", agent.getName());
		Assert.assertEquals("123456", agent.getPassword());
		agent.setName("noalejandro");
		Assert.assertEquals("noalejandro", agent.getName());
		agent.setPassword("contraseñasegura");
		Assert.assertEquals("contraseñasegura", agent.getPassword());
		Assert.assertEquals("23.273425,-15.694777", agent.getLocation());
		agent.setLocation("26.25,-10.77");
		Assert.assertEquals("26.25,-10.77", agent.getLocation());
		agent.setIdautogenerado("125L");
		agent2.setIdautogenerado("126L");
		Assert.assertEquals("125L", agent.getIdautogenerado());
	}

	// Operators
	@Test
	public void PR02() {
		Operator op = new Operator("firestation", "firestation");
		Assert.assertFalse(op.equals(null));
		Operator op2 = new Operator("firestation", "firestation");
		Assert.assertTrue(op.equals(op2));
		Assert.assertEquals("firestation", op.getUsername());
		op.setUsername("policeman");
		Assert.assertEquals("policeman", op.getUsername());
		Assert.assertEquals("firestation", op.getPassword());
		op.setPassword("policeman");
		Assert.assertEquals("policeman", op.getPassword());
		op.setId(100L);
		op2.setId(101L);
		Agent agent = new Agent("juan", "juan", "25,25");
		Incident incident = createIncident(agent, op, "Fire", "A fire has been spotted", 25.0, 25.0);
		Assert.assertEquals(op.getIncidents().size(), 1);
		Assert.assertTrue(op.getIncidents().contains(incident));
		op.setIncidents(new ArrayList<Incident>());
		Assert.assertFalse(op.getIncidents().contains(incident));
		Assert.assertEquals(op.getIncidents().size(), 0);
	}

	// Incidents
	@Test
	public void PR03() {
		Agent agent = new Agent("pablo", "pablo", "25.0,25.0");
		Operator op = new Operator("fireman", "fireman");
		Incident incident = createIncident(agent, op, "Fire", "Fire spotted in the woods", 25.0, 25.0);
		Assert.assertEquals("Fire", incident.getIncidentName());
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
		Agent carolina = new Agent("carolina", "contraseña", "30.0,30.0");
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
		Assert.assertNotEquals(null, msg1);
		Message msg2 = new Message("fire", "FIRE");
		Assert.assertEquals(msg1, msg2);
		Assert.assertEquals("fire", msg1.getMessage());
		Assert.assertEquals("FIRE", msg1.getTopic());
		Message msg3 = new Message("accident", "ACCIDENT");
		Assert.assertNotEquals(msg1, msg3);
	}

	// LatLng
	@Test
	public void PR05() {
		LatLng ll1 = new LatLng(25.0, 25.0);
		Assert.assertNotEquals(ll1, null);
		LatLng ll2 = new LatLng(25.0, 25.0);
		Assert.assertEquals(ll1, ll2);
		Assert.assertTrue(25.0 == ll1.getLat());
		ll1.setLat(24.0);
		Assert.assertTrue(24.0 == ll1.getLat());
		Assert.assertNotEquals(ll1, ll2);
		ll1.setLat(25.0);
		Assert.assertEquals(ll1, ll2);
		Assert.assertTrue(25.0 == ll1.getLng());
		ll1.setLng(24.0);
		Assert.assertTrue(24.0 == ll1.getLng());
		Assert.assertNotEquals(ll1, ll2);
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
