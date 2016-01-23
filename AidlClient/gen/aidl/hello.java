/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: H:\\Other\\AidlClient\\src\\aidl\\hello.aidl
 */
package aidl;
public interface hello extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements aidl.hello
{
private static final java.lang.String DESCRIPTOR = "aidl.hello";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an aidl.hello interface,
 * generating a proxy if needed.
 */
public static aidl.hello asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof aidl.hello))) {
return ((aidl.hello)iin);
}
return new aidl.hello.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_callback:
{
data.enforceInterface(DESCRIPTOR);
aidl.word _arg0;
_arg0 = aidl.word.Stub.asInterface(data.readStrongBinder());
this.callback(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements aidl.hello
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void callback(aidl.word wd) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((wd!=null))?(wd.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_callback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_callback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void callback(aidl.word wd) throws android.os.RemoteException;
}
