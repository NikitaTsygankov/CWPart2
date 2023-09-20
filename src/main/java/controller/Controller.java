package controller;

import model.ParticipantQueue;
import model.ToyMachine;
import viewer.UI;


public class Controller {

    private ParticipantQueue participantQueue;

    private ToyMachine toyMachine;

    private UI userInterface;

    public Controller() {
        this.participantQueue = new ParticipantQueue();
        this.toyMachine = new ToyMachine(participantQueue);
        this.userInterface = new UI();
    }


    public void letsGo() {

        while (true) {
            String toy = userInterface.addToy();
            if (toy.equalsIgnoreCase("стоп")) break;
            else toyMachine.put(toy);
        }
        registration();
    }


    public void registration() {
        while (true) {
            String participant = userInterface.registrations();
            if (participant.equalsIgnoreCase("стоп")) break;
            else {
                participantQueue.addParticipant(participant);
                System.out.println(UI.ticket + participantQueue.getParticipants());
            }
        }
        letsFun();
    }


    public void letsFun() {
        while (true) {
            System.out.println(UI.menu);
            int select = userInterface.select();
            switch (select) {
                case 1 -> toyMachine.getAllToys();
                case 2 -> {
                    toyMachine.letsFun();
                    return;
                }
                case 3 -> {
                    return;
                }
            }
        }
    }
}
