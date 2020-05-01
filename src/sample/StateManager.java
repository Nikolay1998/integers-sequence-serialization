package sample;

import java.util.ArrayList;
import javax.xml.bind.*;
import java.io.File;

public class StateManager {
    public static final String STATE_FILENAME = "state.xml";
    private File file;
    private JAXBContext context;

    public StateManager() throws JAXBException {
        this.file = new File(STATE_FILENAME);
        this.context = JAXBContext.newInstance(State.class);
        ArrayList<Integer> list = new ArrayList<>();
        /*list.add(0);
        list.add(1);
        setState(list);

         */
    }

    public ArrayList<Integer> getState() throws JAXBException {
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return ((State)unmarshaller.unmarshal(file)).getState();
    }

    public void setState(ArrayList state) throws JAXBException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(new State(state), file);
    }

}
