package cabd;

/**
* cabd/CalculatorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Suma.idl
* Wednesday, April 11, 2018 10:42:28 PM VET
*/

public final class CalculatorHolder implements org.omg.CORBA.portable.Streamable
{
  public cabd.Calculator value = null;

  public CalculatorHolder ()
  {
  }

  public CalculatorHolder (cabd.Calculator initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = cabd.CalculatorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    cabd.CalculatorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return cabd.CalculatorHelper.type ();
  }

}
