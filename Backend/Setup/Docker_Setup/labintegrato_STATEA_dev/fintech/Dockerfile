FROM python:3.10
RUN adduser myflask
USER myflask:myflask
WORKDIR /home/myflask
COPY --chown=myflask:myflask ./FinTech ./FinTech
RUN python -m pip install --upgrade pip && \
    pip install -r ./FinTech/Flask/requirements.txt
CMD [ "python", "./FinTech/Flask/FLASK_API.py" ]