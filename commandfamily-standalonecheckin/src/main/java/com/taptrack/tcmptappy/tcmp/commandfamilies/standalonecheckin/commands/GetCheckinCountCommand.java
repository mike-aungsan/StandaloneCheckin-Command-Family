package com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.commands;

import com.taptrack.tcmptappy.tcmp.MalformedPayloadException;
import com.taptrack.tcmptappy.tcmp.commandfamilies.standalonecheckin.AbstractStandaloneCheckinMessage;

public class GetCheckinCountCommand extends AbstractStandaloneCheckinMessage {
    public static final byte COMMAND_CODE = 0x02;


    @Override
    public void parsePayload(byte[] payload) throws MalformedPayloadException {

    }

    @Override
    public byte[] getPayload() {
        return new byte[0];
    }

    @Override
    public byte getCommandCode() {
        return COMMAND_CODE;
    }
}
