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

### Header

| Offset |  Size   |  Type  | Function |
|--------|---------|--------|----------|
| 0x00   | 2 Bytes | UInt16 | Amount of entries in the table.
| 0x02   | 4 Bytes | UInt32 | Total size of the Array in bytes.

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
| 0x1B   | 2 Bytes | UInt16  | Texture Data. Index into the UV Container list.
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

## Texture Table

### Header

| Offset |  Size   |  Type  | Function |
|--------|---------|--------|----------|
| 0x00   | 4 Bytes | UInt32 | Total size of the Texture Table in bytes.
| 0x04   | 2 Bytes | UInt16 | Amount of texture entries.
| 0x06   | 4 Bytes | UInt32 | Offset to the texture array.
| 0x0A   | 4 Bytes | UInt32 | Total size of the texture array in bytes.
| 0x0E   | 2 Bytes | UInt16 | Amount of UV container entries.
| 0x10   | 4 Bytes | UInt32 | Offset to the UV container array.
| 0x14   | 4 Bytes | UInt32 | Total size of the UV container array in bytes.
| 0x18   | 2 Bytes | UInt32 | Amount of UV data entries.
| 0x2A   | 4 Bytes | UInt32 | Offset to the UV data array.   
| 0x2E   | 4 Bytes | UInt32 | Total size of the UV data array in bytes. 

* Total Size: 34 Bytes

### Texture

| Offset |  Size   |  Type  | Function |
|--------|---------|--------|----------|
| 0x00   | 2 Bytes | UInt16 | Texture name. Index into the String table.
| 0x02   | 2 Bytes | UInt16 | Texture path. Index into the String table.

### UV Container

| Offset |  Size   |  Type  | Function |
|--------|---------|--------|----------|
| 0x00   | 2 Bytes | UInt16 | Up Face. Index into the UV data entry.
| 0x02   | 2 Bytes | UInt16 | Down Face. Index into the UV data entry.
| 0x04   | 2 Bytes | UInt16 | North Face. Index into the UV data entry.
| 0x06   | 2 Bytes | UInt16 | South Face. Index into the UV data entry.
| 0x08   | 2 Bytes | UInt16 | East Face. Index into the UV data entry.
| 0x0A   | 2 Bytes | UInt16 | West Face. Index into the UV data entry.

### UV Data

| Offset |  Size   |  Type   | Function |
|--------|---------|---------|----------|
| 0x00   | 2 Bytes | UInt16  | Texture. Index into the texture path list.
| 0x02   | 4 Bytes | Float32 | U Coordinate.
| 0x06   | 4 Bytes | Float32 | U Length.
| 0x0A   | 4 Bytes | Float32 | V Coordinate.
| 0x0E   | 4 Bytes | Float32 | V Length.