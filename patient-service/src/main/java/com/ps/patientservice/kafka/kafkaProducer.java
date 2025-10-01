package com.ps.patientservice.kafka;

import com.ps.patientservice.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class kafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(kafkaProducer.class);
    private final KafkaTemplate<String, byte[]> KafkaTemplate;

    public kafkaProducer(KafkaTemplate<String, byte[]> KafkaTemplate) {
        this.KafkaTemplate = KafkaTemplate;
    }

    public void sendEvent(Patient patient) {
        PatientEvent event = PatientEvent.newBuilder()
                .setPatientId(patient.getId().toString())
                .setName(patient.getName())
                .setEmail(patient.getEmail())
                .setEventType("PATIENT_CREATED")
                .build();

        try{
            KafkaTemplate.send("patient", event.toByteArray());
        } catch (Exception e) {
            log.error("Error sending Patient Created event: {}", event);
        }
    }
}
