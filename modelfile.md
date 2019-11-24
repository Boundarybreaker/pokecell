# Model File Specifications
The structure of the binary model file used for the advanced fabric model format.

## Header

| Offset |   Size   | Function |
|--------|----------|----------|
| 0x00   | 2 Bytes  | MID in ASCII (TBD)
| 0x02   | 2 Byte   | Version Byte (We're starting at 0x0000)
| 0x04   | 4 Bytes  | Offset to the Element Table, relative to start.
| 0x08   | 4 Bytes  | Offset to the Texture Table, relative to start.
| 0x0C   | 4 Bytes  | Offset to the Joints Table, relative to start.
| 0x10   | 4 Bytes  | Offset to the String Table, relative to start.
| 0x14   | 4 Bytes  | Offset to the start of custom data, relative to start.

* Total size: 24 Bytes

## Element Table

| Offset |  Size   |  Type  | Function |
|--------|---------|--------|----------|
| 0x00   | 2 Bytes | UInt16 | Amount of entries in the table.
| 0x02   | 4 Bytes | UInt32 | Total size of the Array in bytes.
| 0x06   | N* Bytes | Array  | Element Table Data.

* Rounded up to 4 bytes. 

### Element Object

| Offset |  Size   |  Type   | Function |
|--------|---------|---------|----------|
| 0x00   | 2 Bytes | UInt16  | Comment. Index into String table.
| 0x02   | 1 Byte  | Bitflag | Property Bitflag,
| 0x03   | 4 Bytes | Float32 | X Offset.
| 0x07   | 4 Bytes | Float32 | Y Offset.
| 0x0B   | 4 Bytes | Float32 | Z Offset.
| 0x0F   | 4 Bytes | Float32 | Width.
| 0x13   | 4 Bytes | Float32 | Length.
| 0x17   | 4 Bytes | Float32 | Height.
| 0x1B   | 2 Bytes | UInt16  | Texture Data. Index into Texture Table
| 0x1F   | 4 Bytes | Float32 | X-Axis Scale. (Optional)
| 0x23   | 4 Bytes | Float32 | Y-Axis Scale. (Optional)
| 0x27   | 4 Bytes | Float32 | Z-Axis Scale. (Optional)
| 0x2B   | 4 Bytes | Float32 | X Rotation Anchor. Relative to offset. (Optional)
| 0x2F   | 4 Bytes | Float32 | Y Rotation Anchor. Relative to offset. (Optional)
| 0x33   | 4 Bytes | Float32 | Z Rotation Anchor. Relative to offset. (Optional)
| 0x37   | 4 Bytes | Float16 | X-Axis Rotation. (Optional)
| 0x3B   | 4 Bytes | Float16 | Y-Axis Rotation. (Optional)
| 0x3F   | 4 Bytes | Float16 | Z-Axis Rotation. (Optional)


#### Property Bitflag
```
T S S S - R X Y Z
| | | |   | | | |
| | | |   | | | +- Has Z-Axis Rotation
| | | |   | | +--- Has Y-Axis Rotation
| | | |   | +----- Has X-Axis Rotation
| | | |   +------- Has custom Rotation Anchor Point
| | | +----------- Has Z-Axis Scale
| | +------------- Has Y-Axis Scale
| +--------------- Has X-Axis Scale
+----------------- Has Transparency
```


