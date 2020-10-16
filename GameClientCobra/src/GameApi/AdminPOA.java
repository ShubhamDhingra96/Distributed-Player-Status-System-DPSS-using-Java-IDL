package GameApi;


/**
* GameApi/AdminPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameServer.idl
* Tuesday, June 23, 2020 8:11:47 AM IST
*/

public abstract class AdminPOA extends org.omg.PortableServer.Servant
 implements GameApi.AdminOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("adminSignIn", new java.lang.Integer (0));
    _methods.put ("getPlayerStatus", new java.lang.Integer (1));
    _methods.put ("suspendAccount", new java.lang.Integer (2));
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
       case 0:  // GameApi/Admin/adminSignIn
       {
         String username = in.read_string ();
         String password = in.read_string ();
         String ip = in.read_string ();
         boolean $result = false;
         $result = this.adminSignIn (username, password, ip);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // GameApi/Admin/getPlayerStatus
       {
         GameApi.Hashtable $result[] = null;
         $result = this.getPlayerStatus ();
         out = $rh.createReply();
         GameApi.hashHelper.write (out, $result);
         break;
       }

       case 2:  // GameApi/Admin/suspendAccount
       {
         String username = in.read_string ();
         String password = in.read_string ();
         String adminip = in.read_string ();
         String usernameToSuspend = in.read_string ();
         boolean $result = false;
         $result = this.suspendAccount (username, password, adminip, usernameToSuspend);
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
    "IDL:GameApi/Admin:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Admin _this() 
  {
    return AdminHelper.narrow(
    super._this_object());
  }

  public Admin _this(org.omg.CORBA.ORB orb) 
  {
    return AdminHelper.narrow(
    super._this_object(orb));
  }


} // class AdminPOA
