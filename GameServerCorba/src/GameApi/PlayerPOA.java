package GameApi;


/**
* GameApi/PlayerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameServer.idl
* Tuesday, June 23, 2020 8:11:46 AM IST
*/

public abstract class PlayerPOA extends org.omg.PortableServer.Servant
 implements GameApi.PlayerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("createPlayerAccount", new java.lang.Integer (0));
    _methods.put ("playerSignIn", new java.lang.Integer (1));
    _methods.put ("playerSignOut", new java.lang.Integer (2));
    _methods.put ("transferAccount", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // GameApi/Player/createPlayerAccount
       {
         String username = in.read_string ();
         String firstName = in.read_string ();
         String lastName = in.read_string ();
         int age = in.read_long ();
         String password = in.read_string ();
         String ip = in.read_string ();
         String $result = null;
         $result = this.createPlayerAccount (username, firstName, lastName, age, password, ip);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // GameApi/Player/playerSignIn
       {
         String username = in.read_string ();
         String password = in.read_string ();
         String ip = in.read_string ();
         boolean $result = false;
         $result = this.playerSignIn (username, password, ip);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // GameApi/Player/playerSignOut
       {
         String username = in.read_string ();
         String ip = in.read_string ();
         String $result = null;
         $result = this.playerSignOut (username, ip);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // GameApi/Player/transferAccount
       {
         String username = in.read_string ();
         String password = in.read_string ();
         String oldpassword = in.read_string ();
         String newpassword = in.read_string ();
         boolean $result = false;
         $result = this.transferAccount (username, password, oldpassword, newpassword);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:GameApi/Player:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Player _this() 
  {
    return PlayerHelper.narrow(
    super._this_object());
  }

  public Player _this(org.omg.CORBA.ORB orb) 
  {
    return PlayerHelper.narrow(
    super._this_object(orb));
  }


} // class PlayerPOA