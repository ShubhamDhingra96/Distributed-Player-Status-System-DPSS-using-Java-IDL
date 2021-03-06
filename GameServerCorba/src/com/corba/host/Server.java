package com.corba.host;

import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import GameApi.AdminHelper;
import GameApi.PlayerHelper;

public class Server {

	public static void main(String[] args) throws InvalidName, ServantNotActive, WrongPolicy,
			org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed, AdapterInactive {
		
		ORB orb = ORB.init(args, null);
		POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		rootPoa.the_POAManager().activate();

		Player player = new Player();
		Admin admin = new Admin();
		admin.setORB(orb);

		org.omg.CORBA.Object plyr = rootPoa.servant_to_reference(player);
		org.omg.CORBA.Object admn = rootPoa.servant_to_reference(admin);

		GameApi.Player plyRef = PlayerHelper.narrow(plyr);
		GameApi.Admin admRef = AdminHelper.narrow(admn);
		

		String service = "IOR:000000000000002b49444c3a6f6d672e6f72672f436f734e616d696e672f4e616d696e67436f6e746578744578743a312e30000000000001000000000000009a000102000000000d3139322e3136382e322e31360000038400000045afabcb0000000020000f424000000001000000000000000200000008526f6f74504f41000000000d544e616d65536572766963650000000000000008000000010000000114000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002";
		org.omg.CORBA.Object objRef = orb.string_to_object(service);
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

		NameComponent administrator[] = ncRef.to_name("Admin");
		NameComponent players[] = ncRef.to_name("Player");

		ncRef.rebind(administrator, admRef);
		ncRef.rebind(players, plyRef);

		System.out.println("Addition Server ready and waiting ...");

		// wait for invocations from clients
		for (;;) {
			orb.run();
		}

	}

}
