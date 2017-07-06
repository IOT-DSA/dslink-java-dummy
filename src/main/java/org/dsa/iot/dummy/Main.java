package org.dsa.iot.dummy;

import org.dsa.iot.dslink.DSLink;
import org.dsa.iot.dslink.DSLinkFactory;
import org.dsa.iot.dslink.DSLinkHandler;
import org.dsa.iot.dslink.node.Node;
import org.dsa.iot.dslink.node.NodeBuilder;
import org.dsa.iot.dslink.node.NodeManager;
import org.dsa.iot.dslink.node.Permission;
import org.dsa.iot.dslink.node.actions.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends DSLinkHandler {
    private Main() {
    }

    private static final Logger LOGGER;

    static {
        LOGGER = LoggerFactory.getLogger(Main.class);
    }

    public static void main(String[] args) {
        DSLinkFactory.start(args, new Main());
    }

    @Override
    public boolean isResponder() {
        return true;
    }

    @Override
    public void onResponderInitialized(DSLink link) {
        NodeManager manager = link.getNodeManager();

        Node superRoot = manager.getNode("/").getNode();
        initProfiles(superRoot);
    }

    private void initProfiles(Node superRoot) {
        NodeBuilder b = superRoot.createChild("defs", false);
        b.setSerializable(false);
        b.setHidden(true);
        Node node = b.build();

        b = node.createChild("profile", false);
        b.build();

        NodeBuilder sayHello = superRoot.createChild("sayHello", false);
        Action sayHelloAction = new Action(Permission.READ, event -> LOGGER.info("Said Hello!"));
        sayHello.setAction(sayHelloAction);
        sayHello.build();

    }
}
