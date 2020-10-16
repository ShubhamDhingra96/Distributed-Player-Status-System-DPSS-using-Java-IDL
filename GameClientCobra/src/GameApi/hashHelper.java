package GameApi;


/**
* GameApi/hashHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from GameServer.idl
* Tuesday, June 23, 2020 8:11:46 AM IST
*/

abstract public class hashHelper
{
  private static String  _id = "IDL:GameApi/hash:1.0";

  public static void insert (org.omg.CORBA.Any a, GameApi.Hashtable[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static GameApi.Hashtable[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = GameApi.HashtableHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (GameApi.hashHelper.id (), "hash", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static GameApi.Hashtable[] read (org.omg.CORBA.portable.InputStream istream)
  {
    GameApi.Hashtable value[] = null;
    int _len0 = istream.read_long ();
    value = new GameApi.Hashtable[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = GameApi.HashtableHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, GameApi.Hashtable[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      GameApi.HashtableHelper.write (ostream, value[_i0]);
  }

}