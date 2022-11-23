package org.paymentstatusrequests;

import java.util.ArrayList;

public class Payload{
    public Credentials credentials;
    public ArrayList<Packet> packet;

    public ArrayList<Packet> getPacket() {
        return packet;
    }

    public void setPacket(ArrayList<Packet> packet) {
        this.packet = packet;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
